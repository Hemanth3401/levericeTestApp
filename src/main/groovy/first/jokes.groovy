package first

import com.leverice.apps.rw.rest.RestCallbackResult

void listAll(){
    currentChannel.post("Listing all the commands that can be used.")
    currentChannel.post("   **/randomJoke** - Random jokes")
}

void randomJoke(){
    rest.execute url: 'https://official-joke-api.appspot.com/jokes/random', method: 'GET', callback: build.callback { randomJokes(null) }
}

void randomJokes(RestCallbackResult res) {
    def head = res.body.asJson
    currentChannel.post("${head.setup}")
    currentChannel.post("**${head.punchline}**")
}