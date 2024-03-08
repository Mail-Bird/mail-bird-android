package dv.lux.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dv.lux.data.repository.AuthOutlookRepositoryImpl
import dv.lux.data.repository.MicrosoftGraphRepositoryImpl
import dv.lux.domain.repository.AuthOutlookRepository
import dv.lux.domain.repository.MicrosoftGraphRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {
    @Singleton
    @Binds
    abstract fun bindAuthOutlookRepository(
        authOutlookRepository: AuthOutlookRepositoryImpl
    ): AuthOutlookRepository

    @Singleton
    @Binds
    abstract fun bindMicrosoftGraphRepository(
        microsoftGraphRepository: MicrosoftGraphRepositoryImpl
    ): MicrosoftGraphRepository
}