package reflection

interface IReflectionRepository {
    fun findById(id: Long): ReflectionDto?

    fun search(
        cond: ReflectionSearchForm,
        limit: Long = 100,
    ): List<ReflectionDto>
}
