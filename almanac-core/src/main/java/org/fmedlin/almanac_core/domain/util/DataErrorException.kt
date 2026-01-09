package org.fmedlin.almanac_core.domain.util

class DataErrorException(
    val error: DataError
): Exception()
