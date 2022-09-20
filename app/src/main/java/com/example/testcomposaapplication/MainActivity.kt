package com.example.testcomposaapplication

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.interaction.InteractionSource
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.testcomposaapplication.data.DummyItems
import com.example.testcomposaapplication.data.ListItem
import com.example.testcomposaapplication.ui.theme.DesignSystemTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import java.text.DateFormatSymbols
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : ComponentActivity() {

    private val locale = Locale("RU", "ru")
    private val simpleDateFormat = SimpleDateFormat("LLLL yyyy", locale)

    private val calendar = MutableStateFlow(Calendar.getInstance(locale))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DesignSystemTheme {
                Surface(color = DesignSystemTheme.colors.backgroundPrimary) {
                    Init()
                }
            }
        }
    }


    @OptIn(ExperimentalMaterialApi::class)
    @Composable
    private fun Init() {
        val calendarState = remember { mutableStateOf(initState()) }
        val coroutineScope = rememberCoroutineScope()
        val bottomSheetState = rememberModalBottomSheetState(
            ModalBottomSheetValue.Hidden
        )

        ModalBottomSheetLayout(
            sheetState = bottomSheetState,
            sheetElevation = 12.dp,
            scrimColor = DesignSystemTheme.colors.backgroundOverlay,
            sheetContent = {
                BackHandler(enabled = bottomSheetState.isVisible) {
                    coroutineScope.launch { bottomSheetState.hide() }
                }
                Column(
                    Modifier
                        .fillMaxWidth()
                        .background(DesignSystemTheme.colors.backgroundPrimary)
                ) {
                    Text(
                        text = stringResource(id = R.string.bottom_sheet_title).format(calendarState.value.day),
                        modifier = Modifier.padding(start = 20.dp, top = 24.dp, end = 20.dp),
                        color = DesignSystemTheme.colors.textHeadline,
                        style = DesignSystemTheme.typography.h3.medium
                    )

                    val lazyListState: LazyListState = rememberLazyListState()

                    LazyColumn(
                        state = lazyListState,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 12.dp)
                    ) {
                        items(items = DummyItems().getDummyList(), itemContent = { item ->
                            when (item) {
                                is ListItem.Header -> DrawListHeader(item)
                                is ListItem.Record -> DrawListRecord(item)
                            }
                        })
                    }
                }
            }
        ) {
            coroutineScope.launch { bottomSheetState.hide() }
            Calendar(
                calendarState = calendarState,
                bottomSheetState = bottomSheetState,
                coroutineScope = coroutineScope
            )
        }
    }

    @OptIn(ExperimentalMaterialApi::class)
    @Composable
    private fun Calendar(
        calendarState: MutableState<CalendarState>,
        bottomSheetState: ModalBottomSheetState,
        coroutineScope: CoroutineScope
    ) {
        val currentCalendar = calendar.collectAsState()

        Column(
            Modifier
                .fillMaxSize()
                .background(DesignSystemTheme.colors.backgroundPrimary)
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp, bottom = 8.dp)
            ) {
                Text(
                    text = simpleDateFormat.format(currentCalendar.value.time).capitalize(locale),
                    style = DesignSystemTheme.typography.h3.medium,
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .padding(start = 20.dp),
                    color = DesignSystemTheme.colors.textHeadline
                )
                Row {
                    Image(
                        painter = painterResource(id = R.drawable.ic_icon_left),
                        contentDescription = "",
                        Modifier.clickable {
                            onArrowClick(currentCalendar.value.time, -1, calendarState)
                        }
                    )
                    Spacer(modifier = Modifier.size(8.dp))
                    Image(
                        painter = painterResource(id = R.drawable.ic_icon_right),
                        contentDescription = "",
                        modifier = Modifier
                            .padding(end = 16.dp)
                            .clickable {
                                onArrowClick(currentCalendar.value.time, 1, calendarState)
                            }
                    )
                }
            }
            val shortWeekdays = DateFormatSymbols.getInstance(locale).shortWeekdays
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                for (index in 2 until shortWeekdays.size) {
                    WeekView(shortWeekdays[index])
                }
                WeekView(weekName = shortWeekdays[1])
            }

            val calendar = Calendar.getInstance(locale).apply {
                time = currentCalendar.value.time
                minimalDaysInFirstWeek = 1
                set(Calendar.DAY_OF_MONTH, 1)
            }

            Column(
                Modifier
                    .wrapContentHeight()
                    .padding(top = 6.dp)
            ) {
                val currentMonth = calendar.get(Calendar.MONTH)
                for (week in 1..calendar.getActualMaximum(Calendar.WEEK_OF_MONTH)) {
                    Row(
                        Modifier
                            .fillMaxWidth()
                            .padding(top = 8.dp, bottom = 8.dp)
                    ) {
                        for (shortWeekday in 2 until shortWeekdays.size) {
                            WeekItem(
                                calendar = calendar,
                                shortWeekday = shortWeekday,
                                currentMonth = currentMonth,
                                calendarState = calendarState
                            )
                        }
                        WeekItem(
                            calendar = calendar,
                            shortWeekday = 1,
                            currentMonth = currentMonth,
                            calendarState = calendarState
                        )
                    }
                }

            }
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(36.dp),
                onClick = {
                    coroutineScope.launch {
                        bottomSheetState.show()
                    }
                },
                enabled = calendarState.value.day != 0,
                shape = RoundedCornerShape(6.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = DesignSystemTheme.colors.brandMtsRed,
                    disabledBackgroundColor = DesignSystemTheme.colors.backgroundOverlay
                ),
            ) {
                Text(
                    text = stringResource(id = R.string.button_text),
                    color = DesignSystemTheme.colors.greyScale0,
                    style = DesignSystemTheme.typography.p2.medium
                )
            }
        }
    }


    @Composable
    private fun RowScope.WeekItem(
        calendar: Calendar,
        shortWeekday: Int,
        currentMonth: Int,
        calendarState: MutableState<CalendarState>
    ) {
        val dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK)

        if (dayOfWeek == shortWeekday && currentMonth == calendar.get(Calendar.MONTH)) {
            WeekDay(
                weekend = dayOfWeek == Calendar.SATURDAY || dayOfWeek == Calendar.SUNDAY,
                year = calendar.get(Calendar.YEAR),
                month = calendar.get(Calendar.MONTH),
                dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH),
                calendarState = calendarState
            )
            calendar.add(Calendar.DAY_OF_MONTH, 1)
        } else {
            WeekSpacer()
        }
    }

    @Composable
    private fun RowScope.WeekView(weekName: String) {
        Text(
            text = weekName.uppercase(locale),
            style = DesignSystemTheme.typography.p3.mediumUppercase,
            color = DesignSystemTheme.colors.textSecondary,
            textAlign = TextAlign.Center,
            modifier = Modifier.weight(1f)
        )
    }

    @Composable
    private fun RowScope.WeekDay(
        weekend: Boolean,
        year: Int,
        month: Int,
        dayOfMonth: Int,
        calendarState: MutableState<CalendarState>
    ) {
        val calendarStateValue = calendarState.value

        val selected = year == calendarStateValue.year &&
                month == calendarStateValue.month &&
                dayOfMonth == calendarStateValue.day
        Text(
            text = "$dayOfMonth",
            style = DesignSystemTheme.typography.h3.regular,
            color = when {
                selected -> DesignSystemTheme.colors.brandMtsRed
                weekend -> DesignSystemTheme.colors.textTertiary
                else -> DesignSystemTheme.colors.textPrimary
            },
            textAlign = TextAlign.Center,
            modifier = Modifier
                .weight(1f)
                .clickable {
                    calendarState.value =
                        CalendarState(year = year, month = month, day = dayOfMonth)
                }
        )
    }

    @Composable
    private fun RowScope.WeekSpacer() {
        Spacer(modifier = Modifier.weight(1f))
    }

    @Composable
    private fun DrawListHeader(header: ListItem.Header) {
        Text(
            text = header.text,
            style = DesignSystemTheme.typography.p2.medium,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 24.dp, start = 20.dp),
            color = DesignSystemTheme.colors.textHeadline
        )
    }

    @Composable
    private fun DrawListRecord(record: ListItem.Record) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 28.dp, end = 20.dp, top = 8.dp, bottom = 8.dp)
        ) {
            val color = DesignSystemTheme.colors.brandMtsRed
            Canvas(
                modifier = Modifier
                    .size(24.dp)
                    .padding(8.dp),
                onDraw = { drawCircle(color = color) },
            )
            Text(
                text = "${record.time} ${record.text}",
                style = DesignSystemTheme.typography.h3.regular,
                color = DesignSystemTheme.colors.textPrimary,
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterVertically)
                    .padding(start = 12.dp)
            )
        }
    }

    private fun onArrowClick(
        time: Date,
        amount: Int,
        calendarState: MutableState<CalendarState>
    ) {
        val calendar = Calendar.getInstance(locale).apply {
            this.time = time
            add(Calendar.MONTH, amount)
        }
        this@MainActivity.calendar.tryEmit(calendar)
        calendarState.value = calendarState.value.copy(day = 0)
    }

    private fun initState(): CalendarState {
        val calendar = Calendar.getInstance()
        val monthNum = calendar.get(Calendar.MONTH)
        return CalendarState(
            year = calendar.get(Calendar.YEAR),
            month = monthNum,
            day = 0
        )
    }
}
