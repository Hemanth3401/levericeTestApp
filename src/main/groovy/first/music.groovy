package first

import com.leverice.apps.rw.rest.RestCallbackResult
import helpers.SomeVars

//def auth = "Bearer BQBsuhFjthI3XypTdaFaiOWUhdwapSEpFrUlfRv4L17r5wSyfRMrn0jtmzrnw1iu12mGiSspwPeTVaG_0mFYFQSVlRhoDrxZaGjHs7vnevgDf11Jw_nSRk0qnNMMzZ7yV_ycZBUSU_Cnj4Apz2z3xRhy_mlRf5emADPKqP4Ayh5trwIcwf9nb-ik_ltWv52YMP3Ddx6e6P9RSBQz3TqS64rU1R2y0K1VWP0biUwOhz8o0ot-rOQr_VIWAZIHMJjjp6rmTSev3pYw0wrUxwmtOqoZESYtFF5wyes8TdQo"
// BQBvBp-3yUehtXeMNbfUeXr-7CmusAlWcLW7Mtwo6H9cBjhWpSm6PxseHB_6_iIsbc6nLj8mAOZ9q7FvdZ6Og6_7WHhtAH7fhuprRVXkzysK8TJkcJ1yC1DbdvSdmHpqI96vj6ybYuIx7eLObjjeyXj0aDL_vQHMnn0e_TiZYVdHc6eLb3e3jxxhTJrqmy3n6aJuzd6OT5UfctlPXrELzwf-RlFD2GuVOYZo9ZPBa42QUVAZ_Vqmkrh6b1PcKDn5cO4YSTXGtqm3mSklDqO4adnITj5R7S6wfN7V_CfI
// BQBvBp-3yUehtXeMNbfUeXr-7CmusAlWcLW7Mtwo6H9cBjhWpSm6PxseHB_6_iIsbc6nLj8mAOZ9q7FvdZ6Og6_7WHhtAH7fhuprRVXkzysK8TJkcJ1yC1DbdvSdmHpqI96vj6ybYuIx7eLObjjeyXj0aDL_vQHMnn0e_TiZYVdHc6eLb3e3jxxhTJrqmy3n6aJuzd6OT5UfctlPXrELzwf-RlFD2GuVOYZo9ZPBa42QUVAZ_Vqmkrh6b1PcKDn5cO4YSTXGtqm3mSklDqO4adnITj5R7S6wfN7V_CfI
void listAll(){
    currentChannel.post("Listing all the commands that can be used from spotify.")
    currentChannel.post("   **/searchPlayList {search name}** - Playlist search in spotify")
    currentChannel.post("   **/searchArtist {search name}** - Artists search in spotify")
    currentChannel.post("   **/searchAlbum {search name}** - Album search in spotify")
    currentChannel.post("   **/searchTrack {search name}** - Track search in spotify")
    currentChannel.post("   **/searchShow {search name}** - Shows search in spotify")
    currentChannel.post("   **/searchEpisode {search name}** - Episode search in spotify")
}

void searchPlayList(String[] search){
   String queryString = ""
    search.each {
      queryString = queryString + it + " "
    }
    queryString = queryString.trim().replaceAll(" ", "%20")
    rest.execute url: 'https://api.spotify.com/v1/search?q='+queryString+'&type=playlist&limit=5', headers: ["Content-Type": "application/json", "Accept": "application/json","Authorization": "Bearer BQBvBp-3yUehtXeMNbfUeXr-7CmusAlWcLW7Mtwo6H9cBjhWpSm6PxseHB_6_iIsbc6nLj8mAOZ9q7FvdZ6Og6_7WHhtAH7fhuprRVXkzysK8TJkcJ1yC1DbdvSdmHpqI96vj6ybYuIx7eLObjjeyXj0aDL_vQHMnn0e_TiZYVdHc6eLb3e3jxxhTJrqmy3n6aJuzd6OT5UfctlPXrELzwf-RlFD2GuVOYZo9ZPBa42QUVAZ_Vqmkrh6b1PcKDn5cO4YSTXGtqm3mSklDqO4adnITj5R7S6wfN7V_CfI"] ,  method: 'GET', callback: build.callback { searchResults(null) }
}

void searchArtist(String[] search){
    String queryString = ""
    search.each {
        queryString = queryString + it + " "
    }
    queryString = queryString.trim().replaceAll(" ", "%20")
    rest.execute url: 'https://api.spotify.com/v1/search?q='+queryString+'&type=artist&limit=5', headers: ["Content-Type": "application/json", "Accept": "application/json","Authorization": "Bearer BQBvBp-3yUehtXeMNbfUeXr-7CmusAlWcLW7Mtwo6H9cBjhWpSm6PxseHB_6_iIsbc6nLj8mAOZ9q7FvdZ6Og6_7WHhtAH7fhuprRVXkzysK8TJkcJ1yC1DbdvSdmHpqI96vj6ybYuIx7eLObjjeyXj0aDL_vQHMnn0e_TiZYVdHc6eLb3e3jxxhTJrqmy3n6aJuzd6OT5UfctlPXrELzwf-RlFD2GuVOYZo9ZPBa42QUVAZ_Vqmkrh6b1PcKDn5cO4YSTXGtqm3mSklDqO4adnITj5R7S6wfN7V_CfI"] ,  method: 'GET', callback: build.callback { searchResultsArtists(null) }
}

void searchAlbum(String[] search){
    String queryString = ""
    search.each {
        queryString = queryString + it + " "
    }
    queryString = queryString.trim().replaceAll(" ", "%20")
    rest.execute url: 'https://api.spotify.com/v1/search?q='+queryString+'&type=album&limit=5', headers: ["Content-Type": "application/json", "Accept": "application/json","Authorization": "Bearer BQBvBp-3yUehtXeMNbfUeXr-7CmusAlWcLW7Mtwo6H9cBjhWpSm6PxseHB_6_iIsbc6nLj8mAOZ9q7FvdZ6Og6_7WHhtAH7fhuprRVXkzysK8TJkcJ1yC1DbdvSdmHpqI96vj6ybYuIx7eLObjjeyXj0aDL_vQHMnn0e_TiZYVdHc6eLb3e3jxxhTJrqmy3n6aJuzd6OT5UfctlPXrELzwf-RlFD2GuVOYZo9ZPBa42QUVAZ_Vqmkrh6b1PcKDn5cO4YSTXGtqm3mSklDqO4adnITj5R7S6wfN7V_CfI"] ,  method: 'GET', callback: build.callback { searchResultsAlbum(null) }
}

void searchTrack(String[] search){
    String queryString = ""
    search.each {
        queryString = queryString + it + " "
    }
    queryString = queryString.trim().replaceAll(" ", "%20")
    rest.execute url: 'https://api.spotify.com/v1/search?q='+queryString+'&type=track&limit=5', headers: ["Content-Type": "application/json", "Accept": "application/json","Authorization": "Bearer BQBvBp-3yUehtXeMNbfUeXr-7CmusAlWcLW7Mtwo6H9cBjhWpSm6PxseHB_6_iIsbc6nLj8mAOZ9q7FvdZ6Og6_7WHhtAH7fhuprRVXkzysK8TJkcJ1yC1DbdvSdmHpqI96vj6ybYuIx7eLObjjeyXj0aDL_vQHMnn0e_TiZYVdHc6eLb3e3jxxhTJrqmy3n6aJuzd6OT5UfctlPXrELzwf-RlFD2GuVOYZo9ZPBa42QUVAZ_Vqmkrh6b1PcKDn5cO4YSTXGtqm3mSklDqO4adnITj5R7S6wfN7V_CfI"] ,  method: 'GET', callback: build.callback { testResult(null) }
}

void searchShow(String[] search){
    String queryString = ""
    search.each {
        queryString = queryString + it + " "
    }
    queryString = queryString.trim().replaceAll(" ", "%20")
    rest.execute url: 'https://api.spotify.com/v1/search?q='+queryString+'&type=show&limit=5', headers: ["Content-Type": "application/json", "Accept": "application/json","Authorization": "Bearer BQBvBp-3yUehtXeMNbfUeXr-7CmusAlWcLW7Mtwo6H9cBjhWpSm6PxseHB_6_iIsbc6nLj8mAOZ9q7FvdZ6Og6_7WHhtAH7fhuprRVXkzysK8TJkcJ1yC1DbdvSdmHpqI96vj6ybYuIx7eLObjjeyXj0aDL_vQHMnn0e_TiZYVdHc6eLb3e3jxxhTJrqmy3n6aJuzd6OT5UfctlPXrELzwf-RlFD2GuVOYZo9ZPBa42QUVAZ_Vqmkrh6b1PcKDn5cO4YSTXGtqm3mSklDqO4adnITj5R7S6wfN7V_CfI"] ,  method: 'GET', callback: build.callback { testResult(null) }
}

void searchEpisode(String[] search){
    String queryString = ""
    search.each {
        queryString = queryString + it + " "
    }
    queryString = queryString.trim().replaceAll(" ", "%20")
    rest.execute url: 'https://api.spotify.com/v1/search?q='+queryString+'&type=episode&limit=5', headers: ["Content-Type": "application/json", "Accept": "application/json","Authorization": "Bearer BQBvBp-3yUehtXeMNbfUeXr-7CmusAlWcLW7Mtwo6H9cBjhWpSm6PxseHB_6_iIsbc6nLj8mAOZ9q7FvdZ6Og6_7WHhtAH7fhuprRVXkzysK8TJkcJ1yC1DbdvSdmHpqI96vj6ybYuIx7eLObjjeyXj0aDL_vQHMnn0e_TiZYVdHc6eLb3e3jxxhTJrqmy3n6aJuzd6OT5UfctlPXrELzwf-RlFD2GuVOYZo9ZPBa42QUVAZ_Vqmkrh6b1PcKDn5cO4YSTXGtqm3mSklDqO4adnITj5R7S6wfN7V_CfI"] ,  method: 'GET', callback: build.callback { testResult(null) }
}

void testResult(RestCallbackResult res){
    def head = res.body.asString
    currentChannel.post("${head}")
}

void searchResults(RestCallbackResult res) {
    def head = res.body.asJson
    List music = head.playlists.items as List
    music.each {
        currentChannel.post("Song Name: **${it.name}**")
        currentChannel.post("${it.external_urls.spotify}")
        currentChannel.post("Song Sung by : **${it.owner.display_name}**")
        currentChannel.post("")
    }
}

void searchResultsArtists(RestCallbackResult res) {
    def head = res.body.asJson
    List music = head.artists.items as List
    music.each {
        currentChannel.post("Name: **${it.name}**")
        currentChannel.post("Total Foolowers: **${it.followers.total}**")
        currentChannel.post("Link to Profile : ${it.external_urls.spotify}")
    }
}

void searchResultsAlbum(RestCallbackResult res) {
    def head = res.body.asJson
    List music = head.albums.items as List
    music.each {
        currentChannel.post("Name: **${it.name}**")
        currentChannel.post("Link to Music: ${it.external_urls.spotify}")
        currentChannel.post("   Song by : ${it.artists.name}")
        currentChannel.post("   Link to Profile : ${it.artists.external_urls.spotify}")
    }
}