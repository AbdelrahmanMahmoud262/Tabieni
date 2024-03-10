package com.tabieni

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import com.tabieni.domain.usecase.TestUseCase
import com.tabieni.ui.theme.TabieniTheme
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TabieniTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    val viewmodel by viewModels<testViewModel>()
                    val items by viewmodel.get().collectAsState(initial = emptyList())
                    LazyColumn {
                        items(items.size){
                            Text(text = items[it].toSorah.toString(),
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(16.dp))

                            HorizontalDivider()
                        }
                    }
                }
            }
        }
    }
}

@HiltViewModel
class testViewModel @Inject constructor(
    private val testUseCase:TestUseCase
) :ViewModel(){

    fun get() = testUseCase.getMemorize()
}
