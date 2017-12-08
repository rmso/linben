package com.example.samsung.linben;

import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObject2;
import android.support.test.uiautomator.UiSelector;
import android.support.test.uiautomator.Until;
import android.test.InstrumentationTestCase;

/**
 * Created by Raquel on 08/12/2017.
 */

public class CadastroCausaTeste extends InstrumentationTestCase {

    private UiDevice device;

    @Override
    public void setUp() throws Exception {
        device = UiDevice.getInstance(getInstrumentation());
        device.pressHome();
        device.wait(Until.hasObject(By.desc("Apps")), 5000);

        UiObject2 appsButton = device.findObject(By.desc("Apps"));
        appsButton.click();
        device.wait(Until.hasObject(By.text("Linben")), 5000);

        UiObject2 linbenApp = device.findObject(By.text("Linben"));
        linbenApp.click();
        device.wait(Until.hasObject(By.text("Open navigation drawer")), 3000);

        UiObject2 botaoCriar = device.findObject(By.text("criar"));
        botaoCriar.click();
        device.wait(Until.hasObject(By.text("Concluir")), 5000);

        UiObject editarNome = new UiObject(new UiSelector().text("Joana Pereira da Silva").className("android.widget.EditText"));
        editarNome.setText("Nepomuceno");

        UiObject editarTipoSanguineo = new UiObject(new UiSelector().text("A+").className("android.widget.EditText"));
        editarTipoSanguineo.setText("B+");

        UiObject editarDoenca = new UiObject(new UiSelector().text("Leucemia").className("android.widget.EditText"));
        editarDoenca.setText("Acidente");

        UiObject editarDescricao = new UiObject(new UiSelector().text("Descrição da situação").className("android.widget.EditText"));
        editarDescricao.setText("Meu filho sofreu um acidente de moto e precisa de doação de sangue");

        UiObject2 criarCausa = device.findObject(By.text("Concluir"));
        criarCausa.click();
        device.wait(Until.hasObject(By.text("Open navigation drawer")),70000);

        super.setUp();
    }

    public void testName() throws Exception {
    }
}
