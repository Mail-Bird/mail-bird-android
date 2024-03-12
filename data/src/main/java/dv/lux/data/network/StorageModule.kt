package dv.lux.data.network

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import dv.lux.data.BuildConfig
import dv.lux.utilities.preference.SecureStoragePreference


@Module
@InstallIn(SingletonComponent::class)
class StorageModule {

    @Provides
    fun provideSecretStorage(@ApplicationContext context: Context): SecureStoragePreference {
        return SecureStoragePreference(
            context,
            BuildConfig.STORAGE_FILE_NAME,
            BuildConfig.STORAGE_MASTER_KEY_ALIAS
        )
    }
}