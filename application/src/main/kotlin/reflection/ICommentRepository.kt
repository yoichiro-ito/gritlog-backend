package reflection

interface ICommentRepository {
    fun findById(id: Long): CommentDto?
    fun findAllByReflection(reflectionId: Long): List<CommentDto>
}