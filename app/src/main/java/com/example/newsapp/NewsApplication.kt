package com.example.newsapp

import android.app.Application
import com.example.newsapp.di.topHeadLinesModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration

class NewsApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidContext(this@NewsApplication)
        }
    }


    private fun initKoin(
        config : KoinAppDeclaration? = null
    ){
        startKoin {
            config?.invoke(this)
            modules(topHeadLinesModule)
        }
    }

}
