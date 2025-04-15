package com.iq.newbaseappmarch25

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.iq.newbaseappmarch25.screens.UserDetailScreen
import com.iq.newbaseappmarch25.screens.UserListScreen
import com.iq.newbaseappmarch25.ui.theme.NewBaseAppMarch25Theme
import com.iq.newbaseappmarch25.viewmodel.GithubViewModel
import dagger.hilt.android.AndroidEntryPoint

@OptIn(ExperimentalMaterial3Api::class)
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: GithubViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NewBaseAppMarch25Theme {
// A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Scaffold(
                        modifier = Modifier.fillMaxSize(),
                        topBar = {
                            CenterAlignedTopAppBar(
                                title = {
                                    Text(
                                        text = stringResource(R.string.app_name),
                                        fontSize = 20.sp,
                                        fontWeight = FontWeight.Bold
                                    )
                                }
                            )
                        }
                    ) { values ->

                        AppNavigation(viewModel, values)

                    }

                }
            }
        }
    }
}

@Composable
fun AppNavigation(viewModel: GithubViewModel, values: PaddingValues) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "userList",
        modifier = Modifier
            .fillMaxSize()
            .padding(values)) {
        composable("userList") {
            UserListScreen(viewModel) { username ->
                navController.navigate("userDetail/$username")
            }
        }
        composable("userDetail/{username}") { backStackEntry ->
            val username = backStackEntry.arguments?.getString("username") ?: return@composable
            UserDetailScreen(viewModel, username)
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NewBaseAppMarch25Theme {
        Greeting("Android")
    }
}