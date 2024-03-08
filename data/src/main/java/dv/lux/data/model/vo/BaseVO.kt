package dv.lux.data.model.vo

import dv.lux.domain.model.BaseModel

abstract class BaseVO<out BM : BaseModel> {
    abstract fun toModel(): BM?
}
