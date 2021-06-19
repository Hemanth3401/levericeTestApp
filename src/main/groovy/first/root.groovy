package first

void afterInstall() {
    workspace.root.facets << "first.root"
    workspace.channels.find("/Announcements").post("The Facets that are avaliable.")
    workspace.channels.find("/Announcements").post("    1. Info ")
    workspace.channels.find("/Announcements").post("    2. Jokes ")
    workspace.channels.find("/Announcements").post("    3. Music ")
    workspace.channels.find("/Announcements").post("    4. News ")
    workspace.channels.find("/Announcements").post("    5. Weather ")
    workspace.channels.find("/Announcements").post("😊 Add this to you channel for full pledge Usage. 😊")
}