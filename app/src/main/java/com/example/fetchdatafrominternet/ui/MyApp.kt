package com.example.fetchdatafrominternet.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.fetchdatafrominternet.R
import com.example.fetchdatafrominternet.ui.screens.AppViewModel
import com.example.fetchdatafrominternet.ui.screens.HomeScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyApp() {


    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    Scaffold(
        topBar = {

            CenterAlignedTopAppBar(
                modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
                scrollBehavior = scrollBehavior,
                title = {
                    Text(text = stringResource(id = R.string.top_bar))
                },
            )
        }
    ) {
        Surface(modifier = Modifier.fillMaxSize().padding(it)) {
            println(it)
            val appViewModel: AppViewModel = viewModel()
            HomeScreen(appUiState = appViewModel.appUiState);
        }

    }

}