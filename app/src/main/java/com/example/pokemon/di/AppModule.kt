package com.example.pokemon.di

import com.example.pokemon.data.remote.PokemonAPI
import com.example.pokemon.data.remote.PokemonAPI.Companion.BASE_URL
import com.example.pokemon.data.repository.PokemonRepositoryImpl
import com.example.pokemon.domain.repository.PokemonRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun providePokemonApi(): PokemonAPI {
        return Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(PokemonAPI::class.java)
    }

    @Singleton
    @Provides
    fun providePokemonRepository(
        api: PokemonAPI
    ) = PokemonRepositoryImpl(api)
}