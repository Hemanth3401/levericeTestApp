package first

import com.leverice.apps.rw.rest.RestCallbackResult

void listAll(){
    currentChannel.post("Listing all the commands that can be used from spotify.")
    currentChannel.post("   **/search {search name}** - Search about weather at a certain region of intrest.")
}


void search(String[] place) {
    String queryString = ""
    place.each {
        queryString = queryString + it + " "
    }
    queryString = queryString.trim().replaceAll(" ", "%20")
    rest.execute url: 'http://api.weatherapi.com/v1/current.json?key=f2ed86ac1c4141d4a8b95631211606&q=' + queryString + '&aqi=no', method: 'GET', callback: build.callback { searchPlace(null) }
}

void searchPlace(RestCallbackResult res) {
    def head = res.body.asJson
    currentChannel.post("Weather Report is as follows:")
    currentChannel.post("   Location Name: **${head.location.name}**")
    currentChannel.post("   Location Region: **${head.location.region}**")
    currentChannel.post("   Location Country: **${head.location.country}**")
    currentChannel.post("   Location locat Time: **${head.location.localtime}**")
    currentChannel.post("   Current Temperacture in C: **${head.current.temp_c}**")
    currentChannel.post("   Current Temperacture in F: **${head.current.temp_f}**")
    if (head.current.is_day == 1){
        currentChannel.post("   The Day is : **Morning**")
    }
    else{
        currentChannel.post("   The Day is : **Night**")
    }
    currentChannel.post("   Current Wind Speed in mph: **${head.current.wind_mph}**")
    currentChannel.post("   Temperature feels like in C: **${head.current.feelslike_c}**")
    currentChannel.post("   Temperature feels like in F: **${head.current.feelslike_f}**")
}