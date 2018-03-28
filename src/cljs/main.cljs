(ns main
  (:require [rum.core :as rum]))

(rum/defc main-page []
          [:h3 "hello world"])

(defn init-background []
  (js/console.log "background mode activate")
  (js/console.log (.getUdid js/udid))
  )

(defn rum-mount []
  (.addEventListener js/document "deviceready"
                     (fn []
                       (js/console.log "cordova deviceready")
                       (.enable js/cordova.plugins.backgroundMode)
                       (.disableWebViewOptimizations js/cordova.plugins.backgroundMode)
                       (.overrideBackButton js/cordova.plugins.backgroundMode)
                       (js/console.log "move background")
                       (.moveToBackground cordova.plugins.backgroundMode)
                       (.on js/cordova.plugins.backgroundMode "activate" init-background)
                       ))
  (js/console.log "mount. .")
  (rum/mount (main-page)
             (.getElementById js/document "app")))