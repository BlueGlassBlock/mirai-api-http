/*
 * Copyright 2020 Mamoe Technologies and contributors.
 *
 * 此源代码的使用受 GNU AFFERO GENERAL PUBLIC LICENSE version 3 许可证的约束, 可以在以下链接找到该许可证.
 * Use of this source code is governed by the GNU AGPLv3 license that can be found through the following link.
 *
 * https://github.com/mamoe/mirai/blob/master/LICENSE
 */

package net.mamoe.mirai.api.http.adapter.internal.action

import net.mamoe.mirai.Bot
import net.mamoe.mirai.api.http.HttpApiPluginBase
import net.mamoe.mirai.api.http.adapter.internal.dto.EmptyAuthedDTO
import net.mamoe.mirai.api.http.adapter.internal.dto.QQDTO
import net.mamoe.mirai.api.http.adapter.internal.dto.SessionDTO

private val mahVersion by lazy {
    val desc = HttpApiPluginBase.description
    desc.version.toString()
}

/**
 * 获取API-HTTP插件信息
 */
internal fun onAbout(): Map<String, String> {
    return mapOf("version" to mahVersion)
}

/**
 * 获取 session 信息
 */
internal fun onGetSessionInfo(dto: EmptyAuthedDTO): SessionDTO {
    return SessionDTO(dto.session.key, QQDTO(dto.session.bot.asFriend))
}

/**
 * 获取所有已登录账号列表
 */
internal fun onGetBotsList(): List<Long> {
    return Bot.instances.map { it.bot.id }
}