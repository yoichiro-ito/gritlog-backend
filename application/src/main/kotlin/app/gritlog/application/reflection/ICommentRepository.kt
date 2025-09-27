package app.gritlog.application.reflection

interface ICommentRepository {
    fun findById(id: Long): app.gritlog.application.reflection.CommentDto?

    fun findAllByReflection(reflectionId: Long): List<app.gritlog.application.reflection.CommentDto>
}
