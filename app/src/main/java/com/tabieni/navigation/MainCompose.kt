package com.tabieni.navigation

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DismissibleDrawerSheet
import androidx.compose.material3.DismissibleNavigationDrawer
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.tabieni.navigation.DrawerParams.drawerButtons
import com.tabieni.navigation.components.AppDrawerItemInfo
import com.tabieni.resources.ui.theme.TabieniTheme
import kotlinx.coroutines.launch


@Composable
fun MainCompose(
    navController: NavHostController = rememberNavController(),
    drawerState: DrawerState = rememberDrawerState(initialValue = DrawerValue.Closed),
) {

    var currentPick by remember { mutableStateOf(MainNavOption.HomeScreen) }


    val scope = rememberCoroutineScope()

    TabieniTheme(useDarkTheme = false) {
        Surface {
            DismissibleNavigationDrawer(
                drawerState = drawerState,
                drawerContent = {
                    DismissibleDrawerSheet {
                        Spacer(Modifier.height(12.dp))
                        drawerButtons.forEach { item ->
                            NavigationDrawerItem(
                                icon = {
                                    Icon(
                                        painter = painterResource(id = item.drawableId),
                                        contentDescription = null,
                                        tint = MaterialTheme.colorScheme.primary
                                    )
                                },
                                label = {
                                    Text(
                                        stringResource(id = item.title),
                                        color = MaterialTheme.colorScheme.primary
                                    )
                                },
                                selected = item.drawerOption == currentPick,
                                onClick = {
                                    if (currentPick == item.drawerOption) {
                                        scope.launch {
                                            drawerState.close()
                                        }
                                        return@NavigationDrawerItem
                                    }
                                    currentPick = item.drawerOption
                                    navController.navigate(currentPick.name) {
                                        popUpTo(NavRoutes.MainRoute.name)
                                    }
                                    scope.launch {
                                        drawerState.close()
                                    }
                                },
                                modifier = Modifier.padding(horizontal = 12.dp),
                            )
                        }
                    }
                },
            ) {
                NavHost(
                    navController,
                    startDestination = NavRoutes.MainRoute.name
                ) {
                    mainGraph(drawerState)
                }
            }
        }
    }
}

enum class NavRoutes {
    MainRoute,
}

object DrawerParams {
    val drawerButtons = arrayListOf(
        AppDrawerItemInfo(
            MainNavOption.HomeScreen,
            com.tabieni.resources.R.string.home,
            com.tabieni.resources.R.drawable.ic_home,
            com.tabieni.resources.R.string.home
        ),
        AppDrawerItemInfo(
            MainNavOption.PlanScreen,
            com.tabieni.resources.R.string.plan,
            com.tabieni.resources.R.drawable.ic_plan,
            com.tabieni.resources.R.string.plan
        )
    )
}

@Preview
@Composable
fun MainActivityPreview() {
    MainCompose()
}