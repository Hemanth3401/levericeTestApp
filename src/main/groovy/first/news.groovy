package first

import com.leverice.apps.rw.rest.RestCallbackResult

void listAll(){
    currentChannel.post("Listing all Comands that this app contains")
    currentChannel.post("   **/todayNews** - for Getting Today's news in English Language.")
    currentChannel.post("   **/todayNewsGerman** - for Getting Today's news in Germany Language.")
    currentChannel.post("   **/todayNewsTelugu** - for Getting Today's news in Telugu Language.")
    currentChannel.post("   **/todayNewsHindi** - for Getting Today's news in Hindi Language.")
}

void todayNews(){
    rest.execute url: 'https://gnews.io/api/v4/top-headlines?token=a548ecc9120e4c82a48a23675176bef2&lang=en&max=2', method: 'GET', callback: build.callback { reveiveNews(null) }
}

void todayNewsGerman(){
    rest.execute url: 'https://gnews.io/api/v4/top-headlines?token=a548ecc9120e4c82a48a23675176bef2&lang=de&max=2', method: 'GET', callback: build.callback { reveiveNews(null) }
}

void todayNewsTelugu(){
    rest.execute url: 'https://gnews.io/api/v4/top-headlines?token=a548ecc9120e4c82a48a23675176bef2&lang=te&max=2', method: 'GET', callback: build.callback { reveiveNews(null) }
}

void todayNewsHindi(){
    rest.execute url: 'https://gnews.io/api/v4/top-headlines?token=a548ecc9120e4c82a48a23675176bef2&lang=hi&max=2', method: 'GET', callback: build.callback { reveiveNews(null) }
}

void reveiveNews(RestCallbackResult res) {
    def head = res.body.asJson
    List article = head.articles as List
    /*article.each {
        currentChannel.post("Title: ${it.title}")
        currentChannel.post("Url: ${it.url}")
    }*/
    def subscriber1 = currentChannel.subscribers
    def someMarkup1 = build.markup {
        text("Title : **${article.title[0]}**")
        newLine()
        button("Read More", build.callback {
            client.goToUrl("${article.url[0]}", true)
        })
    }
    currentChannel.post(
            system: true,
            markup: someMarkup1,
            recipients: subscriber1,
            countForUnread: false
    )
    def subscriber2 = currentChannel.subscribers
    def someMarkup2 = build.markup {
        text("Title : **${article.title[1]}**")
        newLine()
        button("Read More", build.callback {
            client.goToUrl("${article.url[1]}", true)
        })
    }
    currentChannel.post(
            system: true,
            markup: someMarkup2,
            recipients: subscriber2,
            countForUnread: false
    )
}
