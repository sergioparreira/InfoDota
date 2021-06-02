package com.example.dotainfo.network

import androidx.room.Room
import com.example.dotainfo.database.OpenDataBase
import com.example.dotainfo.repository.DotaRepository
import com.example.dotainfo.repository.DotaRepositoryImpl
import com.example.dotainfo.service.DotaApi
import com.example.dotainfo.ui.heroes.HeroesViewModel
import com.example.dotainfo.ui.ViewModelSplashScreen
import com.example.dotainfo.ui.proPlayers.ProPlayersViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val apiModules = module {

    single<DotaRepository> { DotaRepositoryImpl(get(),get()) }
    single <DotaApi>{ createWebService("https://api.opendota.com/api/") }
    single{ get<OpenDataBase>().ProPlayer() }
    single { Room.databaseBuilder(androidApplication(), OpenDataBase::class.java, "database.db").build() }


}

val viewModelModules = module {
    viewModel { ProPlayersViewModel() }
    viewModel { ViewModelSplashScreen() }
    viewModel { HeroesViewModel() }
}


inline fun <reified T> createWebService(url: String): T {
    val retrofitCliente = Retrofit.getRetrofitInstance(url)

    return retrofitCliente.create(T::class.java)
}