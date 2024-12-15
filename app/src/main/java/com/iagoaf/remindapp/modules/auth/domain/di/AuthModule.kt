package com.iagoaf.remindapp.modules.auth.domain.di

import com.iagoaf.remindapp.modules.auth.data.datasource.LoginDataSourceImpl
import com.iagoaf.remindapp.modules.auth.data.repository.LoginRepositoryImpl
import com.iagoaf.remindapp.modules.auth.domain.datasource.LoginDataSource
import com.iagoaf.remindapp.modules.auth.domain.repository.LoginRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class AuthModule {

    @Provides
    @Singleton
    fun provideLoginRepository(
        loginDataSource: LoginDataSource
    ): LoginRepository{
        return LoginRepositoryImpl(loginDataSource)
    }

    @Provides
    @Singleton
    fun provideLoginDataSource(
    ): LoginDataSource{
        return LoginDataSourceImpl()
    }

}