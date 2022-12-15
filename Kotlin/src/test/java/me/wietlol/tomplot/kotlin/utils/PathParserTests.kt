package me.wietlol.tomplot.kotlin.utils

import me.wietlol.tomplot.kotlin.LocalTestModule
import org.junit.Test

class PathParserTests : LocalTestModule()
{
	@Test
	fun `assert that a single name can be parsed`() = unitTest {
		val name = "name"
		
		val path = PathParser.parsePath(name)
		
		assertThat(path)
			.isEqualTo(listOf("name"))
	}
	
	@Test
	fun `assert that multiple names can be parsed`() = unitTest {
		val name = "path.to.name"
		
		val path = PathParser.parsePath(name)
		
		assertThat(path)
			.isEqualTo(listOf("path", "to", "name"))
	}
	
	@Test
	fun `assert that escaped names can be parsed`() = unitTest {
		val name = "`single long. name`"
		
		val path = PathParser.parsePath(name)
		
		assertThat(path)
			.isEqualTo(listOf("single long. name"))
	}
	
	@Test
	fun `assert that multiple escaped names can be parsed`() = unitTest {
		val name = "`single long. name`.with.`other-names`"
		
		val path = PathParser.parsePath(name)
		
		assertThat(path)
			.isEqualTo(listOf("single long. name", "with", "other-names"))
	}
}
