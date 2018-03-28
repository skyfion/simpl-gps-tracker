(defproject track "1.0.0"
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/clojurescript "1.9.671"]
                 ;; rum stuff
                 [rum "0.10.8"]
                 [funcool/rumext "1.0.0"]
                 [org.roman01la/citrus "3.0.0"]
                 [cljsjs/react-select "1.0.0-rc.1"]]
  :plugins [[lein-cljsbuild "1.1.3"]]
  :source-paths ["src"]

  :cljsbuild
   {:builds
   [{:id           "dev"
     :source-paths ["src/cljs"]
     :figwheel     {:on-jsload "mount"}
     :compiler     {:main                 mount
                    :output-to            "www/js/app.js"
                    :output-dir           "www/js/out"
                    :asset-path           "js/out"
                    :source-map-timestamp true
                    ;:preloads             [devtools.preload]
                    ;:external-config      {:devtools/config {:features-to-install :all}}
                    }}

    {:id           "min"
     :source-paths ["src/cljs"]
     :compiler     {:main            mount
                    :output-to       "www/js/app.js"
                    :optimizations   :advanced
                    :closure-defines {goog.DEBUG false}
                    :pretty-print    false}}

    ]}
  )