package com.tabieni.presentation_plan

import android.content.res.Configuration
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.KeyboardArrowDown
import androidx.compose.material.icons.rounded.KeyboardArrowUp
import androidx.compose.material3.Button
import androidx.compose.material3.DrawerState
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.tabieni.domain.entity.Collection
import com.tabieni.presentation_plan.model.Spinner
import com.tabieni.presentation_plan.utils.dayOfMonth
import com.tabieni.resources.components.Base
import com.tabieni.resources.ui.theme.poppins
import java.time.DayOfWeek
import java.time.format.TextStyle
import java.util.Calendar
import java.util.Date
import java.util.Locale

@Composable
fun PlanScreen(
    drawerState: DrawerState,
    viewModel: PlanViewModel = hiltViewModel(),
) {
    Base(drawerState = drawerState) {

        val state by viewModel.state

        PlanBrief(viewModel = viewModel)
    }
}

@Composable
private fun PlanBrief(
    viewModel: PlanViewModel,
) {

    val state by viewModel.state

    BoxWithConstraints(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFDAD0E1))
    ) {
        val maxHeight = this.maxHeight

        val topHeight: Dp = maxHeight / 3
        val bottomHeight: Dp = maxHeight * 2 / 3

        val centerHeight = maxHeight / 6

        val centerPaddingBottom = bottomHeight - centerHeight / 2

        Top(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.TopCenter)
                .height(topHeight)
        )

        Bottom(
            viewModel = viewModel,
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .height(bottomHeight)
                .padding(top = centerHeight / 2)
        )

        Center(
            viewModel = viewModel,
            modifier = Modifier
                .padding(bottom = centerPaddingBottom)
                .fillMaxWidth()
                .height(centerHeight)
                .align(Alignment.BottomCenter)
        )
    }
}

@Composable
fun Center(modifier: Modifier,viewModel: PlanViewModel) {
    Column(
        modifier = modifier
            .clip(RoundedCornerShape(24.dp))
            .background(Color(0xFFDDBEDD)),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = android.text.format.DateFormat.format(
                "d MMMM",
                Date()
            ).toString(),
            fontFamily = poppins,
            fontWeight = FontWeight.Medium,
            fontSize = 16.sp,
            color = Color.Black,
            modifier = Modifier
                .padding(start = 32.dp, top = 16.dp),
        )


        Row(
            modifier = Modifier
                .fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            val weekDays = listOf(
                DayOfWeek.SUNDAY,
                DayOfWeek.MONDAY,
                DayOfWeek.TUESDAY,
                DayOfWeek.WEDNESDAY,
                DayOfWeek.THURSDAY,
                DayOfWeek.FRIDAY,
                DayOfWeek.SATURDAY
            )
            for (item in weekDays) {
                val selected = item == viewModel.state.value.selectedDayOfWeek
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .clip(CircleShape)
                        .background(if (selected) MaterialTheme.colorScheme.primary else Color.Transparent)
                        .clickable {
                            viewModel.onEvent(PlanEvent.DayOfWeek(item))
                        }
                        .padding(8.dp)

                ) {
                    Text(
                        text = item.getDisplayName(
                            TextStyle.SHORT,
                            Locale.getDefault()
                        ),
                        fontFamily = poppins,
                        fontWeight = FontWeight.Medium,
                        fontSize = 12.sp,
                        color = if (selected) Color.White else Color(0xFF858585),
                    )
                    Text(
                        text = item.dayOfMonth().toString(),
                        fontFamily = poppins,
                        fontWeight = FontWeight.Medium,
                        fontSize = 12.sp,
                        color = if (selected) Color.White else Color.Black,
                    )
                }
            }
        }
    }
}


@Composable
fun Bottom(viewModel: PlanViewModel, modifier: Modifier) {
    Column(
        modifier = modifier
            .verticalScroll(rememberScrollState())
    ) {

    }
}

@Composable
fun PlanItem(
    modifier: Modifier = Modifier,
    item: Collection,
    state: MutableState<PlanState>
) {
    Column(
        modifier = modifier
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = stringResource(R.string.memorize),
            fontFamily = poppins,
            fontWeight = FontWeight.SemiBold,
            fontSize = 16.sp,
            color = MaterialTheme.colorScheme.primary
        )
    }
}

@Composable
private fun Top(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .background(
                brush = Brush.verticalGradient(
                    listOf(
                        Color(0xFFDAD0E1),
                        MaterialTheme.colorScheme.primary
                    )
                )
            ),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            horizontalAlignment = Alignment.End
        ) {
            Text(
                text = "Plan's name",
                fontFamily = poppins,
                fontWeight = FontWeight.SemiBold,
                fontSize = 24.sp,
                color = Color.White,
                modifier = Modifier
                    .padding(start = 32.dp)
            )
            Text(
                text = "365 days left",
                fontFamily = poppins,
                fontWeight = FontWeight.Medium,
                fontSize = 14.sp,
                color = Color.White,
                modifier = Modifier
                    .padding(start = 32.dp),
            )
        }

        Icon(
            painter = painterResource(id = com.tabieni.resources.R.drawable.list),
            contentDescription = stringResource(R.string.more_details),
            tint = Color.White,
            modifier = Modifier
                .padding(end = 32.dp)
        )
    }
}

@Composable
private fun MakeYourPlan() {
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
fun PlanScreenPreview() {
//    PlanScreen(drawerState = DrawerState(initialValue = DrawerValue.Closed))
    PlanBrief(viewModel = hiltViewModel())
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