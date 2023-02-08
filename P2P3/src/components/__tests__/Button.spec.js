import { describe, it, expect } from 'vitest'

import { mount } from '@vue/test-utils'
import Button from "../Button.vue"

describe("Button", () => {
    it ("renders properly", () => {
        const button = mount(Button, { props: { buttontext: "Test button" } })
        expect(button.text()).toContain("Test button")
    })
})