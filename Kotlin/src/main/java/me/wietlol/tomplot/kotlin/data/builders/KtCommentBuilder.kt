// hash: #b2393949
// @formatter:off

package me.wietlol.tomplot.kotlin.data.builders

import me.wietlol.tomplot.kotlin.data.models.*
import me.wietlol.tomplot.kotlin.data.models.DefaultKtComment

// Generated by BitBlock version 1.0.0

// @formatter:on
// @tomplot:customCode:start:f5k3GB
// @tomplot:customCode:end
// @formatter:off

class KtCommentBuilder
{
	var text: MutableList<String>? = mutableListOf()
	
	fun build(): KtComment =
		DefaultKtComment(
			text!!.toMutableList(),
		)
	
	// @formatter:on
	// @tomplot:customCode:start:0ETUWm
	// @tomplot:customCode:end
	// @formatter:off
}
// @formatter:on
