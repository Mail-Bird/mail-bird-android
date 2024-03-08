package dv.lux.domain.usecase

interface BaseUseCase

interface UseCase<in T, out R> : BaseUseCase {
    suspend fun execute(params: T): R
}

interface NonParamUseCase<out R> : BaseUseCase {
    suspend fun execute(): R
}