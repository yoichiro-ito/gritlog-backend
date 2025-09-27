package app.gritlog.application.common

import app.gritlog.application.account.IAccountRepository
import app.gritlog.application.common.exception.NotFoundException

class OperationGuard(
    private val accountRepository: IAccountRepository,
) {
    /**
     * 操作主体アカウントの存在チェック
     */
    fun ensureAccountExists(accountId: Long) {
        if (!accountRepository.existsById(accountId)) {
            throw NotFoundException("Account(id=$accountId) is not found.")
        }
    }
}
