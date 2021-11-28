package com.canonal.jetpacknavigation.provider

import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.os.Bundle
import android.widget.RemoteViews
import androidx.navigation.NavDeepLinkBuilder
import com.canonal.jetpacknavigation.R

class DeepLinkAppWidgetProvider : AppWidgetProvider() {
    override fun onUpdate(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetIds: IntArray
    ) {
        val remoteViews = RemoteViews(
            context.packageName,
            R.layout.widget_deep_link
        )

        //get this data inside DeepLinkFragment with arguments?.getString("myKey")
        val args = Bundle()
        args.putString("myKey", "From Widget")

        val pendingIntent = NavDeepLinkBuilder(context)
            .setGraph(R.navigation.nav_graph)
            .setDestination(R.id.deepLinkFragment)
            .setArguments(args)
            .createPendingIntent()

        remoteViews.setOnClickPendingIntent(R.id.btnWidgetDeepLink, pendingIntent)
        appWidgetManager.updateAppWidget(appWidgetIds, remoteViews)
    }
}