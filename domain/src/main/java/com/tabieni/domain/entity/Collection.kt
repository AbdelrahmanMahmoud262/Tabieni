package com.tabieni.domain.entity

data class Collection(
    val memorize: MemorizeWithSurah? = null,
    val connection: ConnectionWithSurah? = null,
    val revision: RevisionWithSurah? = null
)