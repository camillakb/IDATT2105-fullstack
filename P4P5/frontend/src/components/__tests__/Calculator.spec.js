import { describe, it, expect, vitest } from 'vitest'
import { createTestingPinia } from '@pinia/testing'
import { mount } from '@vue/test-utils'
import Calculator from "../Calculator.vue"

describe("Calculator", () => {
    it ("renders properly", () => {
        const calculator = mount(Calculator, {
            global: {
                plugins: [createTestingPinia({
                    stubActions: false,
                    createSpy: vitest.fn
                })],
            },
        })
        
        //testing that the calculator renders with display and keypad
        expect(calculator.element.innerHTML).toContain("display")
        expect(calculator.element.innerHTML).toContain("keypad")
    })
})
