import { describe, it, expect, vitest } from 'vitest'
import { createTestingPinia } from '@pinia/testing'
import { mount } from '@vue/test-utils'
import Keypad from "../Keypad.vue"

describe("Keypad", () => {
    it ("renders properly", () => {
        const keypad = mount(Keypad, {
            global: {
                plugins: [createTestingPinia({
                    stubActions: false,
                    createSpy: vitest.fn
                })],
            },
        })
        
        //testing that the keypad renders with numbers and operators
        expect(keypad.element.innerHTML).toContain("numbers")
        expect(keypad.element.innerHTML).toContain("operators")
    })
})
