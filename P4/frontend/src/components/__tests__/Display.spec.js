import { describe, expect, test, vitest, vi } from 'vitest'
import { createTestingPinia } from '@pinia/testing'
import { mount } from '@vue/test-utils'
import Display from "../Display.vue"


describe("Display", () => {
    test ("renders properly", () => {
        const display = mount(Display, {
            global: {
                plugins: [createTestingPinia({
                    stubActions: false,
                    createSpy: vitest.fn
                })],
            },
        })
        
        expect(display.text()).toContain("")
        expect(display.element.innerHTML).toContain("readonly")
    })
})