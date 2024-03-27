package com.tabieni.resources.components

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.DrawerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tabieni.resources.R
import com.tabieni.resources.ui.theme.poppins
import kotlinx.coroutines.launch
import kotlin.math.absoluteValue

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Base(drawerState:DrawerState ,content : @Composable () -> Unit) {
    val collapsedFaction = .05f

    val fraction by animateFloatAsState(
        targetValue = if (drawerState.isOpen) 1f else 0f,
        animationSpec = tween(durationMillis = 800), label = "",
    )
    var isAnimRunning by remember {
        mutableStateOf(false)
    }

    Scaffold(
        topBar = {
            val topBarScope = rememberCoroutineScope()
            TopAppBar(
                title = {
                    Text(
                        text = stringResource(id = R.string.app_name),
                        fontSize = 24.sp,
                        style = TextStyle(
                            color = MaterialTheme.colorScheme.primary,
                            fontFamily = poppins,
                            fontWeight = FontWeight.Bold
                        )
                    )
                },
                navigationIcon = {
                    IconButton(onClick = {
                        topBarScope.launch { if (drawerState.isClosed) drawerState.open() else drawerState.close() }
                    }) {
                        Icon(
                            painter = painterResource(id = R.drawable.menu),
                            contentDescription = "Menu Icon",
                            tint = MaterialTheme.colorScheme.primary
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors().copy(containerColor = Color(0xFFDAD0E1))
            )
        },
        modifier = Modifier
            .animateContentSize()
            .graphicsLayer {
                scaleX = (1f - collapsedFaction * fraction)
                scaleY = (1f - collapsedFaction * fraction)
            }
            .clip(if (drawerState.isOpen || fraction.absoluteValue != 0f) RoundedCornerShape(12.dp) else RoundedCornerShape(0.dp))
            .background(Color(0xFFDAD0E1))


    ) { paddingValues ->
        Surface(
            modifier = Modifier
                .padding(paddingValues)
        ) {
            content()
        }
    }
}