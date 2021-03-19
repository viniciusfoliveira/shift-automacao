package br.com.web.shift.suits;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import br.com.web.shift.tests.AlianExpressTest;
import br.com.web.shift.tests.ComprasTest;
import org.junit.runners.Suite.SuiteClasses;


@RunWith(Suite.class)
@SuiteClasses({AlianExpressTest.class, ComprasTest.class})
public class SuitTest {

	
}
