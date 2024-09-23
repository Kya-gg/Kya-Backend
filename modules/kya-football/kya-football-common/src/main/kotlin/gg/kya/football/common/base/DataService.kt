package gg.kya.football.common.base

import org.springframework.transaction.annotation.Transactional

interface DataService<ID, T> {
    /**
     * DTO의 ID가 null이면 insert, 아니면 update 합니다.
     */
    @Transactional
    fun upsert(dto: T): T
}