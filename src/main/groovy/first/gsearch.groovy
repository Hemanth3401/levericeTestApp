package first

import com.leverice.apps.rw.rest.RestCallbackResult

void listAll(){
    currentChannel.post("Listing all the commands that can be used.")
    currentChannel.post("   **/GoogleSearch {search term}** - Google Search about a certain topic of intrest.")
}

void GoogleSearch(String[] search){
    String queryString = ""
    search.each {
        queryString = queryString + it + " "
    }
    queryString = queryString.trim().replaceAll(" ", "%20")
    rest.execute url: 'https://customsearch.googleapis.com/customsearch/v1?cx=b40cf1d0713787d1b&lr=lang_en&num=5&q='+queryString+'&key=AIzaSyA0gYRG0BzX3RiRvgHiEq8QIrUlYWmYaxU', method: 'GET', callback: build.callback { searchResult(null) }
}

void searchResult(RestCallbackResult res) {
    def head = res.body.asString
    currentChannel.post("${head}")
}

//<script async src="https://cse.google.com/cse.js?cx=b40cf1d0713787d1b"></script>
//<div class="gcse-search"></div>
//GET https://customsearch.googleapis.com/customsearch/v1?cx=b40cf1d0713787d1b&lr=lang_en&num=5&q=cars&key=AIzaSyCFPoZlrHe6HpEbALbLST-ROi1cvWb0xto HTTP/1.1
//
//Accept: application/json