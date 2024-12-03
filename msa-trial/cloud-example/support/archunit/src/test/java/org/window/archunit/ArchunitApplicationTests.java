package org.window.archunit;

import com.tngtech.archunit.lang.syntax.ArchRuleDefinition;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ArchunitApplicationTests {

  // ??? ?????? ??? ??? ? ??.
  @Test
  void enforceModuleDependencyRules() {
    //    ArchRuleDefinition.classes()
    //        .that().resideInAPackage("com.example.project.moduleA..")
    //        .should().onlyAccessClassesThat()
    //        .resideInAnyPackage("com.example.project.moduleA..",
    //            "java..") // Allow standard Java dependencies
    //        .check(importedClasses);
    //
    //    ArchRuleDefinition.noClasses()
    //        .that().resideInAPackage("com.example.project.moduleB..")
    //        .should().dependOnClassesThat()
    //        .resideInAPackage("com.example.project.moduleC..")
    //        .check(importedClasses);
    //  }
  }
}
