package com.tabieni.presentation_home

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.tabieni.domain.entity.MemorizeWithSurah
import com.tabieni.resources.R
import com.tabieni.resources.components.Base
import com.tabieni.resources.ui.theme.poppins
import kotlinx.coroutines.launch
import java.util.Locale

@Composable
fun HomeScreen(
    drawerState: DrawerState,
    viewModel: HomeViewModel = hiltViewModel(),
) {

    val scope = rememberCoroutineScope()
    val state = viewModel.state.value
    val snackbarHostState = remember { SnackbarHostState() }


    Base(drawerState) {
        Scaffold(
            snackbarHost = { SnackbarHost(snackbarHostState) }
        ) { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0xFFDAD0E1))
                    .padding(paddingValues)
                    .padding(16.dp)
            ) {

                Greeting()

                Spacer(modifier = Modifier.height(16.dp))

                LastMemorized(state.lastMemorized)

                Spacer(modifier = Modifier.height(16.dp))

                TodayWork()

            }
            if (!state.error.isNullOrBlank()) {
                LaunchedEffect(key1 = "snackbar") {
                    scope.launch {
                        snackbarHostState.showSnackbar(
                            message = state.error.toString(),
                            duration = SnackbarDuration.Long
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun TodayWork() {
    Text(
        text = stringResource(id = R.string.todays_work),
        fontFamily = poppins,
        fontWeight = FontWeight.Medium,
        fontSize = 18.sp,
        color = Color.Black,
        modifier = Modifier
            .padding(start = 16.dp)
    )
}

@Composable
private fun LastMemorized(
    lastMemorized: MemorizeWithSurah?,
    isArabic: Boolean = Locale.getDefault().language.equals("ar"),
) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(10.dp))
            .background(
                Brush.linearGradient(
                    listOf(
                        Color(0xFFDF98FA),
                        Color(0xFF9055FF)
                    )
                )
            )
            .fillMaxWidth(),
        contentAlignment = Alignment.BottomEnd
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
        ) {
            Row {
                Icon(
                    painter = painterResource(id = R.drawable.readme),
                    contentDescription = "Read me",
                    tint = Color.White
                )
                Text(
                    text = stringResource(R.string.last_memorized),
                    fontFamily = poppins,
                    fontWeight = FontWeight.Medium,
                    fontSize = 14.sp,
                    color = Color.White,
                    modifier = Modifier
                        .padding(horizontal = 8.dp)
                )
            }

            Spacer(modifier = Modifier.height(32.dp))

            Text(
                text =
                if (isArabic) lastMemorized?.toSurah?.arabicName
                    ?: stringResource(id = R.string.nothing_memorized)
                else lastMemorized?.toSurah?.englishName
                    ?: stringResource(id = R.string.nothing_memorized),
                fontFamily = poppins,
                fontWeight = FontWeight.SemiBold,
                fontSize = 18.sp,
                color = Color.White
            )


            Text(
                text = stringResource(
                    R.string.ayah_number,
                    lastMemorized?.toAyah ?: 0
                ),
                fontFamily = poppins,
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp,
                color = Color.White
            )
        }

        Image(
            painter = painterResource(id = R.drawable.quran),
            contentDescription = stringResource(R.string.quran),
            modifier = Modifier
                .padding(8.dp)
        )
    }
}

@Composable
private fun Greeting() {
    Text(
        text = stringResource(R.string.alsalam_ealaykum),
        fontFamily = poppins,
        fontWeight = FontWeight.Medium,
        fontSize = 18.sp,
        color = colorResource(id = R.color.lightGrey),
        modifier = Modifier
            .fillMaxWidth()
    )

    Spacer(modifier = Modifier.height(8.dp))

    Text(
        text = "مروه",
        fontFamily = poppins,
        fontWeight = FontWeight.SemiBold,
        fontSize = 25.sp,
        color = MaterialTheme.colorScheme.primary,
        modifier = Modifier
            .fillMaxWidth()
    )
}


@Preview(locale = "en", name = "Home-en")
@Preview(
    locale = "ar-rEG",
    name = "Home-ar",
    uiMode = Configuration.UI_MODE_TYPE_MASK or Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun HomeScreenPreview() {
    HomeScreen(drawerState = DrawerState(initialValue = DrawerValue.Closed))
}

