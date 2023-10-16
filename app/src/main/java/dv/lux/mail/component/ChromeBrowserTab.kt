package dv.lux.mail.component

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.browser.customtabs.CustomTabsIntent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

@Composable
fun ChromeBrowserTab() {
    val ctx = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .fillMaxWidth()
            .fillMaxHeight(),

        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Button(

            modifier = Modifier
                .fillMaxWidth()
                .padding(18.dp),

            onClick = {
                openTab(ctx)
            })
        {
            Text(text = "Open custom chrome tab", modifier = Modifier.padding(8.dp))

        }

    }
}

// on below line we are creating a function to open custom chrome tabs.
fun openTab(context: Context) {
    // on below line we are creating a variable for
    // package name and specifying package name as
    // package of chrome application.
    val package_name = "com.android.chrome"

    // on below line we are creating a variable for
    // our URL which we have to open in chrome tabs
    val URL = "https://www.geeksforgeeks.org"

    // on below line we are creating a variable
    // for the activity and initializing it.
    val activity = (context as? Activity)

    // on below line we are creating a variable for
    // our builder and initializing it with
    // custom tabs intent
    val builder = CustomTabsIntent.Builder()

    // on below line we are setting show title
    // to true to display the title for
    // our chrome tabs.
    builder.setShowTitle(true)

    // on below line we are enabling instant
    // app to open if it is available.
    builder.setInstantAppsEnabled(true)

    // on below line we are setting tool bar color for our custom chrome tabs.
//    builder.setToolbarColor(ContextCompat.getColor(context, R.color.purple_200))

    // on below line we are creating a
    // variable to build our builder.
    val customBuilder = builder.build()

    // on below line we are checking if the package name is null or not.
    if (package_name != null) {
        // on below line if package name is not null
        // we are setting package name for our intent.
        customBuilder.intent.setPackage(package_name)

        // on below line we are calling launch url method
        // and passing url to it on below line.
        customBuilder.launchUrl(context, Uri.parse(URL))
    } else {
        // this method will be called if the
        // chrome is not present in user device.
        // in this case we are simply passing URL
        // within intent to open it.
        val i = Intent(Intent.ACTION_VIEW, Uri.parse(URL))

        // on below line we are calling start
        // activity to start the activity.
        activity?.startActivity(i)
    }

}