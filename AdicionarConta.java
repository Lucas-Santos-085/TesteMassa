package tests;

import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import static org.junit.Assert.*;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

import fabricas.BaseTest;
import pages.ContaPage;
import pages.MenuPage;

/********** Teste dirigido a dados (TDD) **********/

//Baixar
/*<dependency>
<groupId>org.easetech</groupId>
<artifactId>easytest-core</artifactId>
<version>1.4.0</version>
</dependency>*/

@RunWith (DataDrivenTestRunner.class)
@DataLoader(filePaths = "AdicionarContaData.csv")

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AdicionarConta extends BaseTest {
	
	private ContaPage contaPage = new ContaPage();
	private MenuPage menuPage = new MenuPage();
	
	
	@Test 
	public void test1_adicionarConta(@Param(name="nome")String nome, @Param(name="mensagem")String mensagem) {
		
		menuPage.acessarTelaInserirConta();
		
		contaPage.inserirNome(nome);
		contaPage.salvarConta();
		assertEquals(mensagem, contaPage.obterMensagemSucesso());
	}
	

}
