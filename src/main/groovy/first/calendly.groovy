package first

import com.leverice.apps.rw.rest.RestCallbackResult

// eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwczovL2F1dGguY2FsZW5kbHkuY29tIiwiaWF0IjoxNjI0MDIwNTI3LCJqdGkiOiJiYTkyNDFiNC1jMjM5LTQyMzgtYTcxYi02NmJkMWIwNWFmNzMiLCJ1c2VyX3V1aWQiOiJHQkRDVDVQQjdQTkJTWFVIIn0.sTinEY2Rj946-PDvO17YIjRx71h6NGHChxoYuzHkwl8
void notifyCalendly(){
    rest.execute url: 'https://api.calendly.com/scheduled_events/event_uuid/invitees/invitee_uuid', headers: ["Content-Type": "application/json", "Accept": "application/json","Authorization": "Bearer eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwczovL2F1dGguY2FsZW5kbHkuY29tIiwiaWF0IjoxNjI0MDIwNTI3LCJqdGkiOiJiYTkyNDFiNC1jMjM5LTQyMzgtYTcxYi02NmJkMWIwNWFmNzMiLCJ1c2VyX3V1aWQiOiJHQkRDVDVQQjdQTkJTWFVIIn0.sTinEY2Rj946-PDvO17YIjRx71h6NGHChxoYuzHkwl8"] ,  method: 'GET', callback: build.callback { testResult(null) }
}

void testResult(RestCallbackResult res){
    def head = res.body.asString
    currentChannel.post("${head}")
}