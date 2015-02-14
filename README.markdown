[![Status of clj-mandrill build (master branch).](https://travis-ci.org/gws/clj-mandrill.svg?branch=master)]
(https://travis-ci.org/gws/clj-mandrill)

[![Status of clj-mandrill dependencies.](https://jarkeeper.com/gws/clj-mandrill/status.svg)]
(https://jarkeeper.com/gws/clj-mandrill)

# clj-mandrill

A Clojure library for consuming the
[Mandrill](https://mandrillapp.com) API.

## Installation

[![Clojars Project](https://clojars.org/gws/clj-mandrill/latest-version.svg)](https://clojars.org/gws/clj-mandrill)

## Documentation

[API documentation](https://gws.github.io/clj-mandrill/)

## Usage

```clojure
(ns your.app
  (:require [gws.mandrill.client :as client]
            [gws.mandrill.api.messages :as messages]))

; Create a default Mandrill client with your API key. You can also specify a map
; of clj-http parameters, but that's optional.
(def client (client/create "YOUR-SECRET-KEY"))
;(def client (client/create "YOUR-SECRET-KEY" {:socket-timeout 1000}))

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
(messages/send client msg)
```

## Features

The entire [Mandrill API version 1.0](https://mandrillapp.com/api/docs/) is supported.

The API follows the Mandrill API conventions as closely as possible. In other
words, messages calls are in the `gws.mandrill.api.messages` namespace, and the
calls are lowercased functions in that namespace, such as
`gws.mandrill.api.messages/send`.

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

Licensed under the [Apache License version 2.0](https://www.apache.org/licenses/LICENSE-2.0).
