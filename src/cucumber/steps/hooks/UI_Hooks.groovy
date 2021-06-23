package steps.ui.hooks

import geb.Browser
import geb.binding.BindingUpdater
import io.qameta.allure.Allure
import org.openqa.selenium.OutputType

import static cucumber.api.groovy.Hooks.After
import static cucumber.api.groovy.Hooks.Before

// NOTE: if you are using the steps in the geb-cucumber library, binding and unbinding
// will already be taken care of for you

def bindingUpdater
def theBrowser
String endpoint


Before("@GoogleSearch") {
    endpoint = "https://www.google.com/?hl=en"
}

Before("@UI") { scenario ->

    if (!binding.hasVariable('browser')) {
        theBrowser = new Browser()
        theBrowser.setBaseUrl(endpoint)
        bindingUpdater = new BindingUpdater(binding, theBrowser)
        bindingUpdater.initialize()
    } else {
        theBrowser = browser
    }
}

After("@UI") { scenario ->

    bindingUpdater.remove()
    theBrowser.quit()
}
