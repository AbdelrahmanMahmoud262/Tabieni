package com.tabieni.presentation_plan

import android.content.res.Configuration
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.rounded.KeyboardArrowDown
import androidx.compose.material.icons.rounded.KeyboardArrowUp
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.tabieni.presentation_plan.model.Spinner
import com.tabieni.resources.components.Base
import com.tabieni.resources.ui.theme.poppins

@Composable
fun PlanScreen(drawerState: DrawerState) {
    Base(drawerState = drawerState) {

        var selectedPlanItem by remember {
            mutableStateOf<Spinner?>(null)
        }
        var selectedStartingDateItem by remember {
            mutableStateOf<Spinner?>(null)
        }
        var selectedTimesPerWeekItem by remember {
            mutableStateOf<Spinner?>(null)
        }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFDAD0E1))
        ) {

            Column(
                modifier = Modifier
                    .fillMaxSize()
            ) {


                Column(
                    modifier = Modifier
                        .padding(32.dp)
                        .verticalScroll(rememberScrollState())
                ) {
                    Text(
                        text = "Make your plan",
                        fontFamily = poppins,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 16.sp,
                        color = Color.Black
                    )

                    Spacer(modifier = Modifier.height(32.dp))

                    SpinnerItem(
                        title = "Plan Type",
                        message = "Pick Your Plan Type",
                        items = listOf(
                            Spinner(spinnerItemText = "Half Hizb"),
                            Spinner(spinnerItemText = "Quarter Hizb"),
                            Spinner(spinnerItemText = "Juz"),
                        ),
                    ) {
                        selectedPlanItem = it
                    }

                    SpinnerItem(
                        title = "Starting Date",
                        message = "Pick your plan starting date",
                        items = listOf(
                            Spinner(spinnerItemText = "Today"),
                            Spinner(spinnerItemText = "Tomorrow"),
                            Spinner(spinnerItemText = "Next Week"),
                            Spinner(spinnerItemText = "Next Month"),
                        ),
                    ) {
                        selectedStartingDateItem = it
                    }

                    SpinnerItem(
                        title = "How many times a week?",
                        message = "Pick your plan weekly schedule",
                        items = listOf(
                            Spinner(spinnerItemText = "Once a week"),
                            Spinner(spinnerItemText = "Twice a week"),
                            Spinner(spinnerItemText = "Three times a week"),
                            Spinner(spinnerItemText = "Four times a week"),
                        ),
                    ) {
                        selectedTimesPerWeekItem = it
                    }

                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        Button(
                            onClick = {},
                        ) {
                            Text(
                                text = "Make your plan",
                                fontFamily = poppins,
                                fontWeight = FontWeight.Normal,
                                fontSize = 12.sp
                            )
                        }

                    }
                }

            }
        }
    }
}

@Composable
fun SpinnerItem(
    modifier: Modifier = Modifier,
    title: String,
    message: String,
    items: List<Spinner>,
    onItemSelected: (Spinner) -> Unit = {},
) {

    var isExpanded by remember {
        mutableStateOf(false)
    }

    var selectedItem by remember {
        mutableStateOf<Spinner?>(null)
    }

    var prevItem by remember {
        mutableStateOf<Spinner?>(null)
    }

    Column(
        modifier = modifier
            .padding(8.dp)
    ) {

        Text(
            text = title,
            fontFamily = poppins,
            fontWeight = FontWeight.Medium,
            fontSize = 12.sp,
            color = Color.Black,
            modifier = Modifier
                .padding(start = 16.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))

        Row(
            modifier = Modifier
                .clip(RoundedCornerShape(12.dp))
                .defaultMinSize(minWidth = 500.dp)
                .background(Color.White)
                .clickable {
                    isExpanded = !isExpanded
                }
                .padding(start = 12.dp, end = 8.dp, top = 8.dp, bottom = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = message,
                fontFamily = poppins,
                fontWeight = FontWeight.Normal,
                fontSize = 12.sp
            )

            Icon(
                if (!isExpanded) Icons.Rounded.KeyboardArrowDown else Icons.Rounded.KeyboardArrowUp,
                contentDescription = "Expand"
            )
        }

        Spacer(modifier = Modifier.height(12.dp))

        AnimatedVisibility(visible = isExpanded) {
            Column(
                modifier = Modifier
                    .padding(horizontal = 12.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(Color.White)
                    .animateContentSize()
            ) {
                // Spinner items
                items.forEach { spinnerItem ->
                    val selected = selectedItem?.equals(spinnerItem) ?: false
                    // Spinner item
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(60.dp)
                            .background(if (selected) MaterialTheme.colorScheme.secondary.copy(alpha = 0.25f) else Color.White)
                            .clickable {
                                prevItem = selectedItem
                                selectedItem = spinnerItem
                                onItemSelected(spinnerItem)
                            }
                            .animateContentSize(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        val density = LocalDensity.current
                        AnimatedVisibility(
                            visible = selected,
                            enter =  // If this item is under the selected item
                            if (items.indexOf(spinnerItem) > items.indexOf(prevItem)) {
                                // the animation is going downwards
                                slideInVertically(initialOffsetY = { -it })
                            } else {
                                // if it is above the selected item
                                // the animation is going upwards
                                //right
                                slideInVertically(initialOffsetY = { it })
                            },
                            exit =
                            // If this item is under the selected item
                            if (items.indexOf(spinnerItem) > items.indexOf(selectedItem)) {
                                // the animation is going downwards
                                slideOutVertically(targetOffsetY = { -it })
                            } else {
                                // if it is above the selected item
                                // the animation is going upwards
                                //right
                                slideOutVertically(targetOffsetY = { it })
                            }
                        ) {
                            Box(
                                modifier = Modifier
                                    .clip(
                                        RoundedCornerShape(
                                            topEndPercent = 50,
                                            bottomEndPercent = 50
                                        )
                                    )
                                    .background(MaterialTheme.colorScheme.secondary)
                                    .fillMaxHeight()
                                    .width(8.dp)
                            )
                        }

                        Text(
                            text = spinnerItem.spinnerItemText,
                            fontFamily = poppins,
                            fontWeight = FontWeight.Normal,
                            fontSize = 12.sp,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 12.dp)
                                .animateContentSize()
                        )
                    }
                }
            }
        }
    }
}


@Preview(locale = "en", name = "Plan-en")
@Preview(
    locale = "ar-rEG",
    name = "Plan-ar",
    uiMode = Configuration.UI_MODE_TYPE_MASK or Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun HomeScreenPreview() {
    PlanScreen(drawerState = DrawerState(initialValue = DrawerValue.Closed))
}

@Preview(showBackground = true, backgroundColor = 0xFFDAD0E1)
@Composable
private fun SpinnerItemPreview() {
    SpinnerItem(
        title = "Test",
        message = "This is a test",
        items = listOf(
            Spinner(spinnerItemText = "test1"),
            Spinner(spinnerItemText = "test2"),
            Spinner(spinnerItemText = "test3")
        )
    )
}