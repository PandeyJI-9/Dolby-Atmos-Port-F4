/*
 * Copyright (C) 2024-2025 Lunaris AOSP
 * SPDX-License-Identifier: Apache-2.0
 */

package org.lunaris.dolby.ui.components

import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch
import org.lunaris.dolby.R
import org.lunaris.dolby.utils.*

@Composable
fun FloatingNavToolbar(
    currentRoute: String,
    onNavigate: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    val haptic = rememberHapticFeedback()
    val scope = rememberCoroutineScope()
    
    val isHomeSelected = currentRoute == "settings"
    val isEqualizerSelected = currentRoute == "equalizer"
    val isAdvancedSelected = currentRoute == "advanced"
    
    val containerColor = MaterialTheme.colorScheme.primaryContainer
    val onContainerColor = MaterialTheme.colorScheme.onPrimaryContainer
    val primaryColor = MaterialTheme.colorScheme.primary
    val onPrimaryColor = MaterialTheme.colorScheme.onPrimary

    Box(
        modifier = modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        HorizontalFloatingToolbar(
            expanded = true,
            colors = FloatingToolbarDefaults.vibrantFloatingToolbarColors(
                toolbarContainerColor = containerColor,
                toolbarContentColor = onContainerColor
            ),
            modifier = Modifier
                .padding(
                    top = FloatingToolbarDefaults.ScreenOffset,
                    bottom = FloatingToolbarDefaults.ScreenOffset
                )
                .shadow(
                    elevation = 12.dp,
                    shape = MaterialTheme.shapes.extraLarge,
                    ambientColor = MaterialTheme.colorScheme.scrim,
                    spotColor = MaterialTheme.colorScheme.scrim
                )
        ) {
            NavToolbarItem(
                icon = Icons.Default.Home,
                label = stringResource(R.string.home),
                selected = isHomeSelected,
                primaryColor = primaryColor,
                onPrimaryColor = onPrimaryColor,
                containerColor = containerColor,
                onContainerColor = onContainerColor,
                onClick = {
                    scope.launch {
                        haptic.performHaptic(HapticFeedbackHelper.HapticIntensity.CLICK)
                    }
                    onNavigate("settings")
                }
            )
            
            NavToolbarItem(
                icon = Icons.Default.GraphicEq,
                label = stringResource(R.string.equalizer),
                selected = isEqualizerSelected,
                isEqualizer = true,
                primaryColor = primaryColor,
                onPrimaryColor = onPrimaryColor,
                containerColor = containerColor,
                onContainerColor = onContainerColor,
                onClick = {
                    scope.launch {
                        haptic.performHaptic(HapticFeedbackHelper.HapticIntensity.CLICK)
                    }
                    onNavigate("equalizer")
                }
            )
            
            NavToolbarItem(
                icon = Icons.Default.Settings,
                label = stringResource(R.string.advanced),
                selected = isAdvancedSelected,
                primaryColor = primaryColor,
                onPrimaryColor = onPrimaryColor,
                containerColor = containerColor,
                onContainerColor = onContainerColor,
                onClick = {
                    scope.launch {
                        haptic.performHaptic(HapticFeedbackHelper.HapticIntensity.CLICK)
                    }
                    onNavigate("advanced")
                }
            )
        }
    }
}

@Composable
private fun NavToolbarItem(
    icon: ImageVector,
    label: String,
    selected: Boolean,
    primaryColor: Color,
    onPrimaryColor: Color,
    containerColor: Color,
    onContainerColor: Color,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    isEqualizer: Boolean = false
) {
    val currentSelectionKey = remember(selected) { selected }
    
    Surface(
        selected = selected,
        onClick = { onClick() },
        shape = androidx.compose.foundation.shape.CircleShape,
        color = if (selected) primaryColor else containerColor,
        contentColor = if (selected) onPrimaryColor else onContainerColor,
        modifier = modifier.height(48.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .animateContentSize(
                    animationSpec = spring(stiffness = Spring.StiffnessLow)
                )
        ) {
            key(currentSelectionKey) {
                Crossfade(
                    targetState = isEqualizer,
                    animationSpec = tween(300),
                    label = "icon_transition_$label"
                ) { isEq ->
                    if (isEq) {
                        AnimatedEqualizerIconDynamic(
                            modifier = if (selected) Modifier else Modifier.semantics {
                                contentDescription = label
                            },
                            color = if (selected) onPrimaryColor else onContainerColor,
                            size = 24.dp
                        )
                    } else {
                        Icon(
                            imageVector = icon,
                            contentDescription = label,
                            modifier = Modifier.size(24.dp)
                        )
                    }
                }
            }
            
            AnimatedVisibility(
                visible = selected,
                enter = expandHorizontally(
                    animationSpec = spring(stiffness = Spring.StiffnessLow),
                    expandFrom = Alignment.Start
                ) + fadeIn(
                    animationSpec = tween(300)
                ),
                exit = shrinkHorizontally(
                    animationSpec = spring(stiffness = Spring.StiffnessLow),
                    shrinkTowards = Alignment.Start
                ) + fadeOut(
                    animationSpec = tween(300)
                ),
                label = "text_visibility_$label"
            ) {
                Text(
                    text = label,
                    fontSize = 16.sp,
                    maxLines = 1,
                    softWrap = false,
                    overflow = TextOverflow.Clip,
                    modifier = Modifier.padding(start = ButtonDefaults.IconSpacing)
                )
            }
        }
    }
}
