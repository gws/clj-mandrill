# mandrill

A Clojure library for consuming the
[Mandrill](https://mandrillapp.com) API.

## Usage

Available on [Clojars](http://clojars.org/gws/mandrill).

```clojure
[gws/mandrill "0.1.0"]
```

```clojure
(ns your.app
  (:require [gws.mandrill.client :as client]))

; Create a default Mandrill client with your API key. You can also specify a map
; of clj-http parameters, but that's optional.
(def mandrill (client/create "YOUR-SECRET-KEY"))
;(def mandrill (client/create "YOUR-SECRET-KEY" {:socket-timeout 1000}))

; Build up an interesting message to send.
(def msg {:message {:to [{:email "nobody@example.com"
                          :name "Nobody"}]
                    :from_email "you@yourdomain.com"
                    :subject "This is a test"
                    :text "Really interesting text-only content."}})
; You can override the key per-request, per the Mandrill docs. This will
; override your client API key configuration.
;(def msg {:key "YOUR KEY"
;          :message {...}})

; Send the message using the configured Mandrill client.
; Functions are named in an attempt to be consistent with the Mandrill REST API
; endpoints.
(client/messages-send mandrill msg)
```

## Features

Currently only the
[messages](https://mandrillapp.com/api/docs/messages.JSON.html) calls are
implemented.

## Testing

Most of the tests are run against the actual Mandrill API, since Mandrill
provides test API keys. In order to actually run the tests, you need to obtain a
test API key. Once you’ve done this, you can supply the key as an environment
variable:

```sh
# Be absolutely sure this is a test key, not your production key!
MANDRILL_TEST_API_KEY=YOURTESTKEY lein test
```

## License

Copyright © 2014 Gordon Stratton

Distributed under the [ISC License](http://opensource.org/licenses/ISC)
