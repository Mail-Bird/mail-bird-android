package dv.lux.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dv.lux.domain.inject.LocalDataSource
import dv.lux.domain.inject.RemoteDataSource
import dv.lux.domain.inject.Repository
import dv.lux.data.repository.AuthOutlookLocalDataSource
import dv.lux.data.repository.AuthOutlookRemoteDataSource
import dv.lux.data.repository.AuthOutlookRepositoryImpl
import dv.lux.data.repository.MicrosoftGraphLocalDataSource
import dv.lux.data.repository.MicrosoftGraphRemoteDataSource
import dv.lux.data.repository.MicrosoftGraphRepositoryImpl
import dv.lux.domain.repository.AuthOutlookRepository
import dv.lux.domain.repository.MicrosoftGraphRepository

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

    @Binds
    @LocalDataSource
    abstract fun bindAuthOutlookLocalDataSource(
        localDataSource: AuthOutlookLocalDataSource
    ): AuthOutlookRepository

    @Binds
    @RemoteDataSource
    abstract fun bindAuthOutlookRemoteDataSource(
        remoteDataSource: AuthOutlookRemoteDataSource
    ): AuthOutlookRepository

    @Binds
    @Repository
    abstract fun bindAuthOutlookRepository(
        authOutlookRepository: AuthOutlookRepositoryImpl
    ): AuthOutlookRepository

    @Binds
    @LocalDataSource
    abstract fun bindMicrosoftGraphLocalDataSource(
        localDataSource: MicrosoftGraphLocalDataSource
    ): MicrosoftGraphRepository

    @Binds
    @RemoteDataSource
    abstract fun bindMicrosoftGraphRemoteDataSource(
        remoteDataSource: MicrosoftGraphRemoteDataSource
    ): MicrosoftGraphRepository

    @Binds
    @Repository
    abstract fun bindMicrosoftGraphRepository(
        microsoftGraphRepository: MicrosoftGraphRepositoryImpl
    ): MicrosoftGraphRepository
}