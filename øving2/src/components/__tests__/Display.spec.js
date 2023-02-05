import { describe, it, expect } from 'vitest'

import { mount } from '@vue/test-utils'
import Display from "../Display.vue"

describe("Display", () => {
    it ("renders properly", () => {
        const display = mount(Display)
    })
})