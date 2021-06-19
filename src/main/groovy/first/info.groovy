package first

import com.leverice.apps.common.Channel
import com.leverice.apps.rw.rest.RestCallbackResult

void listAll(){
    currentChannel.post("Listing all the commands that can be used. 😊 ")
    currentChannel.post("   **/greet name** - Gretting with a name specified.")
    currentChannel.post("   **/getTime** - Current Time.")
    currentChannel.post("   **/help** - For more information Contact admin & admin name.")
    currentChannel.post("   **/userInfo** - Displays your display name.")
    currentChannel.post("   **/greet** - Hello World with user display name.")
    currentChannel.post("   **/printMyIp** - Print outs your IP address.")
    currentChannel.post("   **/ourRename** - Print outs your IP address.")
    currentChannel.post("   **/getArray** - Get's Array of element at a time.")
    currentChannel.post("   **/buttons** - Testing for buttons.")
    currentChannel.post("   **/story** - Print outs a random story from array of stories.")

}

void greet(name) {
    currentChannel.post("Hello ${name}")
}

void getTime(){
  // String quote = ["Hi their!","Hello their","Welcome abord","We welocome you to your workspace","We Love you", "Your work is amazing"]
    currentChannel.post("${currentTime}")
}

void help(){
    currentChannel.post("You Can contact the Admin for more information")
    currentChannel.post("${userInfo()}")
}

void userInfo(){
    currentChannel.post("${currentUser.displayName} ")
}

void greet() {
    currentChannel.post("Hello world, ${currentUser.displayName}!")
}

void printMyIp() {
    rest.execute url: 'https://api.ipify.org?format=json', method: 'GET', callback: build.callback { reveiveResponse(null) }
}

void reveiveResponse(RestCallbackResult res) {
    def responseBody = res.body.asString
    currentChannel.post(responseBody)
}

void ourRename(String newName) {
    currentChannel.name = newName
}

void onFacedAdded(Channel channel, String addedFacet) {
    currentChannel.post("${currentUser.displayName} added facet ${addedFacet}")
}

void getArray(){
    def stories = ['Hi','Hello','Welcome']
    currentChannel.post("${stories}")
}

void buttons(){
    def subscribers = currentChannel.subscribers
    def someMarkup = build.markup {
        text("Some text ")
        newLine()
        button("Button", build.callback {
            client.goToUrl("https://google.com", true)
        })
    }
    currentChannel.post(
            system: true,
            markup: someMarkup,
            recipients: subscribers,
            countForUnread: false
    )
}

void story(){
    currentChannel.post("This is a story")
}